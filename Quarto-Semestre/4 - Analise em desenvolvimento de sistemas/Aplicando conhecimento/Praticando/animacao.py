
import pygame
import sys
from pygame.locals import *
import random

# Inicialização do Pygame
pygame.init()

# Configurações da tela
WINDOW_WIDTH = 640
WINDOW_HEIGHT = 427
FPS = 30

# Configuração da janela
DISPLAYSURF = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
pygame.display.set_caption('Aquarium Simulation')

# Carregue as imagens
background_image_filename = './4262432.jpg'  # Substitua pelo seu fundo de aquário
sprite_image_filename = './fugu.png'  # Substitua pelo seu sprite de peixe

background = pygame.image.load(background_image_filename).convert()
fishImg = pygame.image.load(sprite_image_filename).convert_alpha()

WHITE = (255, 255, 255)

# Use uma lista para controlar as posições dos peixes
fish_positions = [pygame.Vector2(10, 10), pygame.Vector2(200, 100)]

# Use uma lista para controlar as direções dos peixes
fish_directions = [pygame.Vector2(5, 0), pygame.Vector2(3, 0)]

# Configuração das bolhas
bubbles = []

def generate_bubble():
    x = random.randint(50, WINDOW_WIDTH - 50)
    y = WINDOW_HEIGHT
    size = random.randint(5, 20)
    return pygame.Rect(x, y, size, size)

for _ in range(20):
    bubbles.append(generate_bubble())

fpsClock = pygame.time.Clock()

while True:  # Loop principal do jogo
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()

    # Atualize a posição dos peixes com base nas direções
    for i in range(len(fish_positions)):
        fish_positions[i] += fish_directions[i]

        # Verifique os limites da tela para os peixes
        if fish_positions[i].x < 0 or fish_positions[i].x > WINDOW_WIDTH:
            # Inverter a direção quando o peixe atingir os limites
            fish_directions[i] *= -1

    # Atualize a posição das bolhas
    for bubble in bubbles:
        bubble.move_ip(0, -2)  # Mova a bolha para cima
        if bubble.top <= 0:
            # Reinicie a posição da bolha se ela atingir o topo
            bubble.topleft = (random.randint(50, WINDOW_WIDTH - 50), WINDOW_HEIGHT)

    # Preencha a tela com o fundo do aquário
    DISPLAYSURF.blit(background, (0, 0))

    # Desenhe os peixes na tela
    for pos in fish_positions:
        DISPLAYSURF.blit(fishImg, pos)

    # Desenhe as bolhas na tela
    for bubble in bubbles:
        pygame.draw.ellipse(DISPLAYSURF, WHITE, bubble)

    pygame.display.update()
    fpsClock.tick(FPS)
