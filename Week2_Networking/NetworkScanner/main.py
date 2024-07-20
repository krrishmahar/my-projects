import scapy.all as scapy
import socket
import os


def scan(ip):
    arp_request = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst="ff:ff:ff:ff:ff:ff")
    arp_request_broadcast = broadcast / arp_request
    answered_list = scapy.srp(arp_request_broadcast, timeout=1, verbose=False)[0]
    devices = []

    for element in answered_list:
        device = {
            "ip": element[1].psrc,
            "mac": element[1].hwsrc
        }
        try:
            device["hostname"] = socket.gethostbyname(device["ip"])[0]
        except socket.herror:
            device['hostname'] = "Unknown"
        devices.append(device)
    return devices


def print_devices(device_list):
    print("IP\t\t\tMAC Address\n-----------------------------------------")
    for device in device_list:
        print(f"{device['ip']}\t\t{device['mac']}")
    if not device_list:
        print('\nNo Device Found')


def ping(ip):
    response = os.system('ping -n 1 {}.'.format(ip))
    return response == 0


if __name__ == "__main__":
    # ip_range = "192.168.7.1/24"
    print('''
    TO FIND YOUR IP ADDR OF YOUR DEVICE: SIMPLY OPEN A TERMINAL, TYPE 'ipconfig' AND PRESS ENTER
    USE IP IN [IPV4] OR [DEFAULT GATEWAY]
    ''')

    ip_range = input('Enter thr range of your IP addrs: e.g, 192.168.7.1/24\n')
    devices = scan(ip_range)
    print_devices(devices)
    print('\n-----------------------------------------')
    if devices:
        print('Enter any of above ip addr to 192.168.7.1/24 ping them\n')
        while True:
            print('\nEnter x to exit pinging')
            IP = input('IP: ')
            if IP.lower() == 'x':
                break
            else:
                print(ping(ip=IP))
                print('\n-----------------------------------------')
                continue

