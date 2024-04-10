import pygame
import sys
from pygame.locals import *

pygame.init()

FPS = 30
fpsClock = pygame.time.Clock()

# Configura a janela
DISPLAYSURF = pygame.display.set_mode((400, 300), 0, 32)
pygame.display.set_caption('Animação')

WHITE = (255, 255, 255)
catImg = pygame.image.load('cat.png')
catx = 10
caty = 10
cat_speed = 5  # Velocidade de movimento do gato
rotation_angle = 0

while True:
    DISPLAYSURF.fill(WHITE)

    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()

    keys = pygame.key.get_pressed()
    if keys[K_d]:
        rotation_angle -= 5  # Rotação para a direita
        catx += cat_speed
    elif keys[K_e]:
        rotation_angle += 5  # Rotação para a esquerda
        catx -= cat_speed

    rotated_cat = pygame.transform.rotate(catImg, rotation_angle)

    DISPLAYSURF.blit(rotated_cat, (catx, caty))

    pygame.display.update()
    fpsClock.tick(FPS)
