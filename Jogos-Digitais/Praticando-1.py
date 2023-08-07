import random

class Tank(object):
    def __init__(self, name):
        self.name = name
        self.alive = True
        self.ammo = 5
        self.armor = 60

    def __str__(self):
        if self.alive:
            return "%s (%i armor, %i shells)" % (self.name, self.armor, self.ammo)
        else:
            return "%s (dead)" % self.name

    def fire_at(self, enemy):
        if self.ammo >= 1:
            self.ammo -= 1
            print (self.name, "fires on", enemy.name)
            enemy.hit ()
            return True
        else:
            print (self.name, "has no shells!")

    def hit(self):
        self.armor -= 20
        print (self.name, "is hit")
        if self.armor <= 0:
            self.explode()

    def explode(self):
        self.alive = False
        print (self.name, "explodes!")


tanks = [Tank("Tank 1"), Tank("Tank 2"), Tank("Tank 3"), Tank("Tank 4"), Tank("Tank 5")]

while len(tanks) > 1:
    attacker = random.randint(0, len(tanks) - 1)
    defender = random.randint(0, len(tanks) - 1)
    if attacker != defender:
        tanks[attacker].fire_at(tanks[defender])
        if tanks[defender].alive:
            tanks[defender].hit()
        else:
            tanks.remove(tanks[defender])

print("The winner is:", tanks[0].name)