#!/bin/sh
### BEGIN INIT INFO
# Provides:          mikrobus
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
# Short-Description: Relays symlinks
# Description:       
### END INIT INFO

exporter="$(ls -d /sys/devices/platform/gpio-exporter/)"

# mikrobus directory => gpios (out_RL*, out_LED*, ...)
mkdir -p /dev/mikrobus

for gpio in $(ls -d ${exporter}/out_*)
do
	ln -s ${gpio}/value /dev/mikrobus/$(basename ${gpio})
done

for gpio in $(ls -d ${exporter}/in_*)
do
	ln -s ${gpio}/value /dev/mikrobus/$(basename ${gpio})
done


