import pygame
import sys
from pygame.locals import *

# Inicialização do Pygame
pygame.init()

# Configurações da tela
WINDOW_WIDTH = 640
WINDOW_HEIGHT = 480
FPS = 30

# Configuração da janela
DISPLAYSURF = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
pygame.display.set_caption('Animation')

# Carregue as imagens
background_image_filename = 'sushiplate.jpg'
sprite_image_filename = 'fugu.png'

background = pygame.image.load(background_image_filename).convert()
catImg = pygame.image.load(sprite_image_filename).convert_alpha()

WHITE = (255, 255, 255)

# Use Vector2 para controlar a posição do gato
cat_pos = pygame.Vector2(10, 10)
direction = pygame.Vector2(5, 0)  # Direção inicial: direita

fpsClock = pygame.time.Clock()

while True:  # Loop principal do jogo
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()

    # Atualize a posição do gato com base na direção
    cat_pos += direction

    # Verifique os limites da tela
    if cat_pos.x < 0 or cat_pos.x > WINDOW_WIDTH or cat_pos.y < 0 or cat_pos.y > WINDOW_HEIGHT:
        # Inverter a direção quando o gato atingir os limites
        direction *= -1

    # Preencha a tela com branco
    DISPLAYSURF.fill(WHITE)

    # Desenhe o gato na tela
    DISPLAYSURF.blit(background, (0, 0))
    DISPLAYSURF.blit(catImg, cat_pos)

    pygame.display.update()
    fpsClock.tick(FPS)
