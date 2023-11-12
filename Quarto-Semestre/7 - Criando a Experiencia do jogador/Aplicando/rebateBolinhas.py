import sys, pygame
from pygame.locals import *
from random import *

pygame.init()

# screen
size = (800, 600)
screen = pygame.display.set_mode(size)

pygame.display.set_caption("P A P A - B O L I N H A S")

#Carrega a imagem de fundo
imagem = pygame.image.load("./img/imagem_fundo.png") 

# Define as cores em RGB
BLACK  = (0, 0, 0)
WHITE = (255, 255, 255)
YELLOW = (255, 255, 0)
RED = (255, 0, 0)
random_color = [68, 202, 33]

# Declarando a fonte do placar e variável contadora
font = pygame.font.SysFont('sans',40)
placar = 0

# Posição X e Y do circulo 
posicaoPapaBolinhas = [400, 500]

# Armazena num vetor a Velocidade de movimentacao do circulo 
velocidadePapaBolinhas = [5, 5]

# Variável para iniciar a posição do círculo vermelho
criar = True

# Variáveis de posição do círculo vermelho
X_vermelho = 0
Y_vermelho = 0
dx_vermelho = randint(-5,5)
dy_vermelho = 5


# Variável para contagem de tempo, utilizado para controlar a velocidade de quadros (de atualizações da tela)
clock = pygame.time.Clock()

#criando objeto Clock
CLOCKTICK = pygame.USEREVENT+1
pygame.time.set_timer(CLOCKTICK, 1000) # configurado o timer do Pygame para execução a cada 1 segundo
temporizador = 60


while True:
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        #capturando evendo de relogio a cada 1 segundo e atualizando a variável contadora
        if event.type == CLOCKTICK:
            temporizador = temporizador -1

    if temporizador == 0:
        break

    # Verifica se alguma tecla foi pressionada, e captura o evento
    pressed = pygame.key.get_pressed()

    #Verifica qual tecla (seta) foi pressionada e atualiza o vetor Posicao de acordo com a Velocidade
    if pressed[pygame.K_UP]: posicaoPapaBolinhas[1] -= velocidadePapaBolinhas[1]
    if pressed[pygame.K_DOWN]: posicaoPapaBolinhas[1] += velocidadePapaBolinhas[1]
    if pressed[pygame.K_LEFT]: posicaoPapaBolinhas[0] -= velocidadePapaBolinhas[0]
    if pressed[pygame.K_RIGHT]: posicaoPapaBolinhas[0] += velocidadePapaBolinhas[0]

    #blita a imagem de fundo na tela
    screen.blit(imagem, (0, 0))

    # Desenha um circulo branco na tela
    pygame.draw.circle(screen, WHITE, posicaoPapaBolinhas, 20)

    # Aqui é setado a posição inicial da bola vermelha
    if criar == True:
        X_vermelho = randint(40,760)
        Y_vermelho = 20
        criar = False

    # Velocidade de queda do círculo Vermelho
    Y_vermelho += dy_vermelho
    X_vermelho += dx_vermelho

    # Valores da bola vermelha é atribuido 
    posicaoBolasVermelhas = [X_vermelho,Y_vermelho]
   
    # Desenha o círculo vermelho
    pygame.draw.circle(screen, random_color, posicaoBolasVermelhas, 10)

    # ultrapassar tela cria um novo e rebatendo limites da tela
    if Y_vermelho > 600:
        criar = True
    if Y_vermelho <= 9:
        dy_vermelho = -dy_vermelho #inverte
    if X_vermelho > 790 or X_vermelho < 9:
        dx_vermelho = -dx_vermelho

    # Se o papa bolinhas encostar no círculo vermelho o círculo vermelho é reiniciado
    # CB: Círculo Branco    CV: Círculo Vermelho 
    if (posicaoPapaBolinhas[1] + 20 >= Y_vermelho - 10  and posicaoPapaBolinhas[1] - 20 <= Y_vermelho + 10) and (posicaoPapaBolinhas[0] +20  >= X_vermelho - 10 and posicaoPapaBolinhas[0] - 20 <= X_vermelho + 20): 
        dy_vermelho = -dy_vermelho
        dx_vermelho = randint(-5, 5)
        placar = placar+1
        pygame.mixer.music.load("./som/catch.mp3")
        pygame.mixer.music.play(0)

        #muda cor
        for i in range(3):
            random_color[i] = randint(0, 255)

    # renderizando as fontes do placar na tela
    score1 = font.render('Placar '+str(placar), True, (WHITE))
    screen.blit(score1, (600, 50))

    #rendrizando as fontes do cronometro na tela do usuario
    timer1 = font.render('Tempo ' + str(temporizador), True, (YELLOW))
    screen.blit(timer1, (50, 50))
        
    # Atualiza a tela visivel ao usuario
    pygame.display.flip()

    # Limita a taxa de quadros (framerate) a 60 quadros por segundo (60fps)
    clock.tick(60)

#final de jogo
#Limpando a tela do jogo
frame = pygame.draw.rect(screen, (BLACK), Rect((0, 0), (800, 600)))


textofinal = font.render('Fim de Jogo - Placar final: ' + str(placar), True, (WHITE))
size = font.size(str(textofinal))
screen.blit(textofinal, (size[0]/2.,size[1]/2.))


#atualizamos a tela com uma nova tela de informação final ao jogador
pygame.display.flip()
#pequeno loop game esperando o usuario encerrar
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
