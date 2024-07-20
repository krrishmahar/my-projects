# Simple HTTP Server with Nginx Load Balancing

![Network Diagram](network_diagram.png)

## Requirements

- Python 3.x
- Nginx
- Postman 

## Project Overview

This project demonstrates how to create a simple HTTP server using Python and set up load balancing with Nginx. The project includes instructions for running multiple instances of the HTTP server and configuring Nginx to distribute incoming traffic across these instances.

# Network diagram
```sh
Client
  |
  v
Internet
  |
  v
Nginx (Load Balancer)
  |----------------|----------------|
  v                v                v
HTTP Server 1   HTTP Server 2   HTTP Server 3
```

## Steps to Setup

### Windows

1. **Clone the Repository**

    ```sh
    git clone https://github.com/krrishmahar/project-series.git
    cd project-series/Week2_Networking/HTTPServer
    ```

2. **Create and Activate Virtual Environment**

    ```sh
    python -m venv venv
    .\venv\Scripts\activate
    ```

3. **Run Multiple Instances of HTTP Server**

    ```sh
    python http_server.py 8001
    python http_server.py 8002
    python http_server.py 8003
    ```

4. **Install and Configure Nginx**

    - Install Nginx from the official site: [Nginx Download](https://nginx.org/en/download.html)
    - Replace the `nginx.conf` file with the provided configuration in this repository.

5. **Start Nginx**

    ```sh
    sudo nginx
    ```

6. **Test with Postman**
    - Install Postman from the official site: [Postman Download](https://www.postman.com/downloads/)
    - Open Postman and send a GET request to `http://localhost`.
    - Nginx will distribute the requests across the running HTTP server instances using round robin algorithm.

### Linux

1. **Clone the Repository**

    ```bash
    git clone https://github.com/krrishmahar/project-series.git
    cd project-series/Week2_Networking/HTTPServer
    ```

2. **Create and Activate Virtual Environment**

    ```bash
    python3 -m venv venv
    source venv/bin/activate
    ```


3. **Run Multiple Instances of HTTP Server**

    ```bash
    python3 http_server.py 8001
    python3 http_server.py 8002
    python3 http_server.py 8003
    ```

4. **Install and Configure Nginx**

    - Install Nginx from the official site: [Nginx Download](https://nginx.org/en/download.html)
    - Replace the `nginx.conf` file with the provided configuration in this repository.

5. **Start Nginx**

    ```bash
    sudo systemctl start nginx
    ```

6. **Test with Curl cmd**

    - Simply use 
    ``` bash
    curl 127.0.0.1
    ```

## Note 
- Make sure to replace the `nginx.conf` file with the provided configuration in this repository.
- For them using WSL and Remote desktop, check the IP of windows from linux perspective using cmd
    ``` bash
    cat /etc/resolv.conf | grep nameserver
    ```
- Then Use that IP (172.198.x.x) while using curl command or testing with postman.
    
    
## Contributing

Feel free to fork this repository, make changes, and submit pull requests. Contributions are welcome!

Hit the ⭐ button if you found this useful. #HappyCoding
