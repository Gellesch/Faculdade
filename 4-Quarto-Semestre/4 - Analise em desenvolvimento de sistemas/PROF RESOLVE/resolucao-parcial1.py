import pygame, sys
from pygame.locals import *

pygame.init()

FPS = 30 # frames per second setting
fpsClock = pygame.time.Clock()

# set up the window
DISPLAYSURF = pygame.display.set_mode((400, 300), 0, 32)
pygame.display.set_caption('Animation')

WHITE = (255, 255, 255)
catImg = pygame.image.load('./cat.png')
catx = 10
caty = 10
direction = 'right'
angulo = 0

while True: # the main game loop
    DISPLAYSURF.fill(WHITE)

    for event in pygame.event.get():
        if event.type == KEYDOWN:
            if event.key == K_RIGHT:
                catx += 50
                if catx == 280:
                    catx -= 10
            elif event.key == K_DOWN:
                caty += 50
                if caty == 220:
                    caty =- 10
            elif event.key == K_LEFT:
                catx -= 50
                if catx == 10:
                    catx +=10
            elif event.key == K_UP:
                caty -= 50
                if caty == 10:
                    caty += 10
            elif event.key == K_d:
                angulo += 5
            elif event.key == K_e:
                angulo -= 10


    surf = pygame.transform.rotate(catImg, angulo)
    DISPLAYSURF.blit(surf, (catx, caty))

    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()

    pygame.display.update()
    fpsClock.tick(FPS)
