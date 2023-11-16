import math
import pygame
from pygame.locals import *
from random import randint

SCREEN_WIDTH = 800
SCREEN_HEIGHT = 600
FPS = 60

class Asteroid:
    def __init__(self, x, y, radius):
        self.x = x
        self.y = y
        self.radius = radius
        self.velocity_x = randint(-2, 2)
        self.velocity_y = randint(-2, 2)
        self.color = (randint(0, 255), randint(0, 255), randint(0, 255))
        self.collided = False
        self.visible_time = 60

    def move(self):
        self.x += self.velocity_x
        self.y += self.velocity_y

        if self.x < self.radius or self.x > SCREEN_WIDTH - self.radius:
            self.velocity_x *= -1
        if self.y < self.radius or self.y > SCREEN_HEIGHT - self.radius:
            self.velocity_y *= -1

    def collide(self):
        self.collided = True
        self.color = (255, 0, 0)
        self.visible_time = 60

def check_collision(asteroid1, asteroid2):
    distance = math.sqrt((asteroid1.x - asteroid2.x) ** 2 + (asteroid1.y - asteroid2.y) ** 2)
    return (asteroid1.radius + asteroid2.radius) >= distance

def create_asteroids(num_asteroids):
    asteroids = []
    for _ in range(num_asteroids):
        radius = randint(20, 50)
        x = randint(radius, SCREEN_WIDTH - radius)
        y = randint(radius, SCREEN_HEIGHT - radius)

        while any(check_collision(Asteroid(x, y, radius), ast) for ast in asteroids):
            x = randint(radius, SCREEN_WIDTH - radius)
            y = randint(radius, SCREEN_HEIGHT - radius)

        asteroids.append(Asteroid(x, y, radius))
    return asteroids

def draw_asteroids(screen, asteroids):
    for asteroid in asteroids:
        pygame.draw.circle(screen, asteroid.color, (int(asteroid.x), int(asteroid.y)), asteroid.radius)

def main():
    pygame.init()
    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
    pygame.display.set_caption('Asteroid Collision')
    asteroids = create_asteroids(10)

    clock = pygame.time.Clock()

    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                quit()

        screen.fill((0, 0, 0))

        for asteroid in asteroids:
            if not asteroid.collided:
                asteroid.move()

            if asteroid.collided and asteroid.visible_time > 0:
                asteroid.visible_time -= 1
            elif asteroid.collided and asteroid.visible_time == 0:
                asteroids.remove(asteroid)

        collisions = set()

        for i in range(len(asteroids)):
            for j in range(i + 1, len(asteroids)):
                if not asteroids[i].collided and not asteroids[j].collided:
                    if check_collision(asteroids[i], asteroids[j]):
                        collisions.add(i)
                        collisions.add(j)
                        asteroids[i].collide()
                        asteroids[j].collide()

        if collisions:
            collision_asteroids = [asteroids[i] for i in collisions]
            print(f"Collision occurred involving {len(collision_asteroids)} asteroids")

        draw_asteroids(screen, asteroids)

        pygame.display.flip()
        clock.tick(FPS)

if __name__ == "__main__":
    main()
