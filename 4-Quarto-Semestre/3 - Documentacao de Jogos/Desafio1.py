#Desafio 1
#Para criar uma tela com 6 retângulos que ocupam toda a tela e que tenham suas cores alteradas continuamente através de uma função de lerp, podemos usar o seguinte código:

import pygame
from pygame.locals import *
from sys import exit

pygame.init()

screen = pygame.display.set_mode((640, 480), 0, 32)

def generate_random_color():
    return (
        int(random.randint(0, 255)),
        int(random.randint(0, 255)),
        int(random.randint(0, 255)),
    )

def lerp(start_color, end_color, t):
    return start_color + (end_color - start_color) * t

def draw_rectangle(color, position, size):
    rect = pygame.Rect(position, size)
    surface = pygame.Surface(rect.size, pygame.SRCALPHA)
    surface.fill(color)
    return surface


rectangles = []
for i in range(6):
    color = generate_random_color()
    position = (random.randint(0, 640 - size[0]), random.randint(0, 480 - size[1]))
    size = (random.randint(10, 200), random.randint(10, 200))
    rectangle = draw_rectangle(color, position, size)
    rectangles.append(rectangle)


def update_colors():
    for rectangle in rectangles:
        # calcula o valor de lerp para a cor atual
        t = rectangle.centerx / 640
        color = lerp(rectangle.color, (255, 255, 255), t)
        rectangle.color = color

def draw_screen():
    screen.fill((0, 0, 0))
    for rectangle in rectangles:
        screen.blit(rectangle, rectangle.get_rect())
    pygame.display.flip()

while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            exit()

    update_colors()
    draw_screen()