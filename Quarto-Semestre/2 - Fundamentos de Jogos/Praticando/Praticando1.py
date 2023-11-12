import pygame
import math
from pygame.locals import *
from sys import exit


def rotate(surface, angle):
    x = 0
    y = 0
    move_x, move_y = pygame.mouse.get_pos()
    rel_x, rel_y = move_x - x, move_y - y
    angle = (720 / math.pi) * -math.atan2(rel_y, rel_x)
    rotated_surface = pygame.transform.rotate(surface, angle)
    rotated_rect = rotated_surface.get_rect(center=(300, 300))
    return rotated_surface, rotated_rect


def main():
    pygame.init()
    screen = pygame.display.set_mode([600, 600])
    tank = pygame.image.load('tank.jpg')

    angle = 0

    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                quit()

        screen.fill((255, 255, 255))
        tank_rotated, tank_rotated_rect = rotate(tank, angle)
        screen.blit(tank_rotated, tank_rotated_rect)
        pygame.display.flip()


if __name__ == '__main__':
    main()