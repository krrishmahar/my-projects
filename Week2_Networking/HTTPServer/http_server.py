import http.server
import socketserver
import sys

# PORT = 8080
PORT = int(sys.argv[1]) if len(sys.argv) > 1 else 8000  # using other ports 


Handler = http.server.SimpleHTTPRequestHandler


class CustomHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        if self.path == '/':
            self.path = 'index.html'
        return http.server.SimpleHTTPRequestHandler.do_GET(self)

with socketserver.TCPServer(("", PORT), Handler) as httpd:
    print(f'Serving at port: {PORT}')
    httpd.serve_forever()

