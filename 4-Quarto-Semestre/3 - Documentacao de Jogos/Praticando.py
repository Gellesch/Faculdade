#Para realizar essa atividade, é importante que você tenha assistido à videoaula do Professor Resolve. Na sequência, acesse o arquivo a seguir para consultar a atividade:
 
#Esta atividade vale créditos que, ao final do componente curricular, serão convertidos em nota de participação.

#Exercícios
#1. Crie funções que retornem uma superfície de Retangulos e Circulos, passando como parâmetro os valores necessários para cada forma geométrica (altura, largura, raio, cor, posição inicial, etc)

def create_rectangle(height, width, color, position):
    """
    Creates a rectangle surface

    Args:
        height: The height of the rectangle
        width: The width of the rectangle
        color: The color of the rectangle
        position: The position of the rectangle

    Returns:
        A pygame.Surface object
    """

    rect = pygame.Rect(position, (width, height))
    surface = pygame.Surface(rect.size, pygame.SRCALPHA)
    surface.fill(color)
    return surface


def create_circle(radius, color, position):
    """
    Creates a circle surface

    Args:
        radius: The radius of the circle
        color: The color of the circle
        position: The position of the circle

    Returns:
        A pygame.Surface object
    """

    circle = pygame.draw.circle(
        pygame.Surface((2 * radius, 2 * radius)), color, position, radius
    )
    return circle






