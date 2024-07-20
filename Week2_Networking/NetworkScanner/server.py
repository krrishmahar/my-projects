import socket
import threading

HEADER = 64
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname())  #getting computer ip address by gethostname() / computer name(Lappy1119)
# SERVER = 'xxx.xxx.xxx.xxx' #using own public ip addr which make your server accessible to everyone who knows your public ip

ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
DISCONNECT_MESSAGE = '!DISCONNECT'

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# server = socket.socket(-1, -1)
server.bind(ADDR)


# .AF_INET -> type of address/ family we want
# .SOCK_STREAM -> methods/protocol we use. see socket's constructor

def handle_client(conn, addr):
    print(f'[NEW CONNECTION] {addr} \n')

    connected = True
    while connected:
        msg_length = conn.recv(HEADER).decode(FORMAT)
        if msg_length:
            msg_length = int(msg_length)
            msg = conn.recv(msg_length).decode(FORMAT)
            if msg == DISCONNECT_MESSAGE:
                connected = False

            print(f'[{ADDR}] {msg}')
            conn.send('Message received'.encode(FORMAT))

    conn.close()


def start():  #handle new connection by listen to request and accept the connection
    server.listen()
    print(f'[LISTENING] Server is listening on {SERVER}')
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client,
                                  args=(conn, addr))  #creating thread to give args to target/func handle_client
        thread.start()
        print(f'[ACTIVE CONNECTIONS]  {threading.active_count() - 1}')


print('[STARTING] server is starting')
start()

