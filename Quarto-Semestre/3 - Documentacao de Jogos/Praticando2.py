#2. Crie uma função que gere uma tupla de cores com valores aleatórios.

def generate_random_color():
    """
    Generates a random color tuple

    Returns:
        A tuple of three integers representing the RGB values of the color
    """

    return (
        int(random.randint(0, 255)),
        int(random.randint(0, 255)),
        int(random.randint(0, 255)),
    )