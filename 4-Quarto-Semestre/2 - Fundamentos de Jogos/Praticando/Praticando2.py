import pygame
from pygame.locals import *
from sys import exit


def main():
    pygame.init()
    SCREEN_SIZE = (800, 600)
    screen = pygame.display.set_mode(SCREEN_SIZE, 0, 32)

    tank = pygame.image.load('tank.jpg').convert()

    x, y = 0, 0
    move_x, move_y = 0, 0
    rotate = 0

    while True:
        x, y = pygame.mouse.get_pos()
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                exit()

            if event.type == KEYDOWN:
                if event.key == K_UP:
                    move_y = -5
                elif event.key == K_DOWN:
                    move_y = 5
                elif event.key == K_LEFT:
                    move_x = -5
                elif event.key == K_RIGHT:
                    move_x = 5

            x += move_x
            y += move_y

            screen.fill((255, 255, 255))
            screen.blit(tank, (x, y))

            pygame.display.update()


if __name__ == '__main__':
    main()