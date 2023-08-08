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
            print(self.name, "fires on", enemy.name)
            enemy.hit()
            return True
        else:
            print(self.name, "has no shells!")

    def hit(self):
        self.armor -= 20
        print(self.name, "is hit")
        if self.armor <= 0:
            self.explode()

    def explode(self):
        self.alive = False
        print(self.name, "explodes!")


def create_tanks(num_tanks):
    tanks_dict = {}
    for i in range(num_tanks):
        tank_name = input("Digite o nome do tanque %d: " % (i + 1))
        tanks_dict[chr(97 + i)] = Tank(tank_name)
    return tanks_dict


def print_tank_info(tanks):
    print("Informações dos jogadores:")
    for key, tank in tanks.items():
        print(tank)


def player_choose_target(tanks, current_player):
    target_player = current_player
    while target_player == current_player:
        print("\nJogadores disponíveis para atacar:")
        for key, tank in tanks.items():
            if key != current_player:
                print(key, "-", tank.name)
        target_player = input("Escolha o jogador que deseja atacar: ").lower()
        if target_player not in tanks or target_player == current_player:
            print("Escolha inválida. Tente novamente.")
        else:
            return target_player


def main():
    num_tanks = int(input("Quantos tanques deseja criar (entre 2 e 10)? "))
    num_tanks = max(2, min(10, num_tanks))
    tanks = create_tanks(num_tanks)

    while len(tanks) > 1:
        print_tank_info(tanks)

        current_player = random.choice(list(tanks.keys()))
        print("\nÉ a vez do jogador %s!" % tanks[current_player].name)

        target_player = player_choose_target(tanks, current_player)
        tanks[current_player].fire_at(tanks[target_player])

        if not tanks[target_player].alive:
            tanks.pop(target_player)

    print("\nO vencedor é:", tanks[list(tanks.keys())[0]].name)


if __name__ == "__main__":
    main()