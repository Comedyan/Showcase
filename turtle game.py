import turtle as t
import random as r

class SimpleGameObject(t.Turtle):
    def __init__(self):
        t.Turtle.__init__(self)
        self.penup()
        self.shape("turtle")
        self.color("blue")
        self.speed = 1

    def move(self,w,h):
        self.forward(self.speed)
        if self.xcor() > w/2 or self.xcor() < -w/2:
            self.setheading(180-self.heading())
        if self.ycor() > h/2 or self.ycor() < -h/2:
            self.setheading(360-self.heading())   
    

class Player(SimpleGameObject):
    def turn_left(self):
        self.left(30)
    def turn_right(self):
        self.right(30)
    def inc_speed(self):
        self.speed += 1
    def dec_speed(self):
        if self.speed > 1:
            self.speed -= 1
    def matrix(self):
        w.tracer(5,25)
    

class Target(SimpleGameObject):
    def __init__(self,w,h):
        t.Turtle.__init__(self)
        self.penup()
        self.shape('circle')
        self.color('red')
        self.speed = 1
        self.goto(r.randint(-w/4,w/4),r.randint(-h/4,h/4))
        self.setheading(r.randint(0,360))

class score(t.Turtle):
    def __init__(self,w,h):
        t.Turtle.__init__(self)
        self.penup()
        self.hideturtle()
        self.color("black")
        self.goto(w,h)
        self.score = 0

    def update_score(self):
        self.clear()
        self.write("Score: {}".format(self.score),False,"left",
                   ("Arial",14,"normal"))

    def changeScore(self,p):
        self.score += p
        self.update_score()
        
    
def draw_b(w,h):
    x = w/2
    y = h/2
    worker = t.Turtle()
    worker.speed(0)
    worker.penup()
    worker.goto(x,y)
    worker.pensize(4)
    worker.pendown()
    worker.goto(-x,y)
    worker.goto(-x,-y)
    worker.goto(x,-y)
    worker.goto(x,y)
    worker.penup()
    worker.hideturtle()

def isCapture(p,t,):
    a = p.xcor() - t.xcor()
    b = p.ycor() - t.ycor()
    c = (a**2 + b**2)
    if c < 225:
        return True
    return False

#main
s_width = 900
s_height = 700
b_w = 800
b_h = 600


t.setup(s_width,s_height)
w = t.Screen()
w.title("get things")

draw_b(b_w,b_h)

#class instance
player1 = Player()
targs = []
for x in range(5):
    targ = Target(b_w,b_h)
    targs.append(targ)
    
scorekeeper = score(-b_w/2,(s_height+b_h)//4)


t.listen()
t.onkey(player1.turn_left,"Left")
t.onkey(player1.turn_right,"Right")
t.onkey(player1.inc_speed,"Up")
t.onkey(player1.dec_speed,"Down")
t.onkey(player1.matrix,"M")

lineupX = 0
lineupY = int((s_height+b_h)/4)

#game loop
w.tracer(2,25)
while True:
    player1.move(b_w,b_h)
    for k in targs:
        k.move(b_w,b_h)
        
        if isCapture(player1,k):
            k.speed = 0
            k.goto(lineupX,lineupY)
            lineupX += 30
            scorekeeper.changeScore(15)
    if scorekeeper.score >= 75:
        print("Win")
        break

t.exitonclick()
