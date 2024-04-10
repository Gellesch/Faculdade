import pygame
from pygame.locals import *
from sys import exit

pygame.init()
SCREEN_SIZE =(800,600)
screen = pygame.display.set_mode(SCREEN_SIZE, 0 ,32)

tank = pygame.image.load('tank.jpg').convert()

x,y=0,0
move_x, move_y = 0,0
rotate = 0

while True:
    x, y = pygame.mouse.get_pos()
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            exit()

        x += move_x
        y += move_y

        screen.fill((255,255,255))
        screen.blit(tank,(x,y))

        pygame.display.update()
