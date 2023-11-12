#Desafio 2
#Para alterar o programa anterior para que as cores sejam alteradas de acordo com a movimentação do mouse sobre cada um dos retângulos, podemos usar o seguinte código:

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
