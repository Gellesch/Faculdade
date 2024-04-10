import pygame
import math
from pygame.locals import *
from sys import exit

def main():
    pygame.init()
    screen = pygame.display.set_mode([600, 600])
    clock = pygame.time.Clock()

    tank = pygame.image.load('tank.jpg')
    tank_rect = tank.get_rect(center=(300, 300))
    tank_speed = 2
    tank_rotation_speed = 3

    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                exit()

        keys = pygame.key.get_pressed()
        tank_direction = pygame.Vector2(0, 0)
        
        if keys[K_UP]:
            tank_direction.y -= 1
        if keys[K_DOWN]:
            tank_direction.y += 1
        if keys[K_LEFT]:
            tank_direction.x -= 1
        if keys[K_RIGHT]:
            tank_direction.x += 1
        
        if tank_direction.length() > 0:  # Verifica se o vetor de direção não tem comprimento zero
            tank_direction.normalize_ip()
            tank_rotation = math.degrees(math.atan2(tank_direction.y, tank_direction.x))
            tank = pygame.transform.rotate(pygame.image.load('tank.jpg'), -tank_rotation)  # Carrega e rotaciona a imagem

        tank_rect.move_ip(tank_speed * tank_direction.x, tank_speed * tank_direction.y)

        screen.fill((255, 255, 255))
        screen.blit(tank, tank_rect)

        pygame.display.flip()
        clock.tick(60)

if __name__ == '__main__':
    main()

