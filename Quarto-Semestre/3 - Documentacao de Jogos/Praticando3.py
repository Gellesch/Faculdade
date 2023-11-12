#3. Desenhe na tela retângulos e círculos em posições, tamanho e cores aleatórias na tela, usando os métodos criados nos itens anteriores.

import pygame
from pygame.locals import *
from sys import exit

pygame.init()

screen = pygame.display.set_mode((640, 480), 0, 32)

def draw_random_shapes():
    
    surface = pygame.Surface((640, 480))
    surface.fill((0, 0, 0))

    for i in range(10):
        height = random.randint(10, 200)
        width = random.randint(10, 200)
        color = generate_random_color()
        position = (random.randint(0, 640 - width), random.randint(0, 480 - height))
        rect = create_rectangle(height, width, color, position)
        surface.blit(rect, rect.get_rect())

    
    for i in range(10):
        radius = random.randint(10, 100)
        color = generate_random_color()
        position = (random.randint(0, 640 - 2 * radius), random.randint(0, 480 - 2 * radius))
        circle = create_circle(radius, color, position)
        surface.blit(circle, circle.get_rect())

    return surface

def draw_screen():
    screen.fill((0, 0, 0))
    screen.blit(draw_random_shapes(), (0, 0))
    pygame.display.flip()

while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            exit()

    draw_screen()
