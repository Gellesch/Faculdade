import math
import pygame
from pygame.locals import *
from random import randint

class Asteroide:
    def __init__(self, x, y, raio):
        self.x = x
        self.y = y
        self.raio = raio
        self.velocidade_x = randint(-2, 2)
        self.velocidade_y = randint(-2, 2)
        self.cor = (randint(0, 255), randint(0, 255), randint(0, 255))

    def mover(self):
        self.x += self.velocidade_x
        self.y += self.velocidade_y

        # Verificar limites da tela para rebater
        if self.x < self.raio or self.x > 800 - self.raio:
            self.velocidade_x *= -1
        if self.y < self.raio or self.y > 600 - self.raio:
            self.velocidade_y *= -1

def verificar_colisao(ast1, ast2):
    distancia = math.sqrt((ast1.x - ast2.x) ** 2 + (ast1.y - ast2.y) ** 2)
    if (ast1.raio + ast2.raio) >= distancia:
        return True
    else:
        return False

def criar_asteroides(num_asteroides):
    asteroides = []
    for _ in range(num_asteroides):
        raio = randint(20, 50)
        x = randint(raio, 800 - raio)
        y = randint(raio, 600 - raio)

        # Verificar se o novo asteroide colide com algum já existente
        while any(verificar_colisao(Asteroide(x, y, raio), ast) for ast in asteroides):
            x = randint(raio, 800 - raio)
            y = randint(raio, 600 - raio)

        asteroides.append(Asteroide(x, y, raio))
    return asteroides

def desenhar_asteroides(screen, asteroides):
    for asteroide in asteroides:
        pygame.draw.circle(screen, asteroide.cor, (int(asteroide.x), int(asteroide.y)), asteroide.raio)

def main():
    pygame.init()
    screen = pygame.display.set_mode((800, 600))
    pygame.display.set_caption('Asteroid Collision')
    asteroides = criar_asteroides(10)

    ordem_colisoes = []  # Lista para armazenar a ordem das colisões

    clock = pygame.time.Clock()

    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                quit()

        screen.fill((0, 0, 0))  # Preencha a tela com preto para limpar os quadros anteriores

        for asteroide in asteroides:
            asteroide.mover()

        colisoes = set()  # Conjunto para armazenar índices dos asteroides que colidiram

        for i in range(len(asteroides)):
            for j in range(i + 1, len(asteroides)):
                if verificar_colisao(asteroides[i], asteroides[j]):
                    colisoes.add(i)
                    colisoes.add(j)

        if colisoes:
            # Armazenar asteroides que colidiram
            colisoes_asteroides = [asteroides[i] for i in colisoes]
            ordem_colisoes.append(colisoes_asteroides)

            # Remover asteroides que colidiram
            asteroides = [ast for i, ast in enumerate(asteroides) if i not in colisoes]

        desenhar_asteroides(screen, asteroides)

        pygame.display.flip()
        clock.tick(60)  # Limita a taxa de quadros para 60 por segundo

        # Imprime a ordem das colisões
        if ordem_colisoes:
            print("Ordem das colisões:")
            for i, colisao in enumerate(ordem_colisoes):
                tamanhos = [ast.raio for ast in colisao]
                print(f"Colisão {i + 1}: {tamanhos}")

if __name__ == '__main__':
    main()
