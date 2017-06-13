# Wifi

## Hotspot

```
root@imx7s-warp:~# modprobe bcmdhd
root@imx7s-warp:~#echo 2 > /sys/module/bcmdhd/parameters/op_mode
root@imx7s-warp:~# /etc/init.d/networking restart
root@imx7s-warp:~# /etc/init.d/dnsmasq restart
root@imx7s-warp:~# /etc/init.d/hostapd restart
```

## TODO
