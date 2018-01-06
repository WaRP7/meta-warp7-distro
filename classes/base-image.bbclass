DESCRIPTION = "Basic image"
LICENSE = "MIT"

# set password to iot
inherit extrausers
EXTRA_USERS_PARAMS = " \
    usermod -P iot root; \
    "

inherit core-image

# Package
IMAGE_FEATURES += "package-management"

# SSH 
IMAGE_FEATURES += "ssh-server-dropbear"

# SPLASH SCREEN
IMAGE_FEATURES += "splash"

AUDIO_INSTALL = " \
    alsa-utils \
    alsa-tools \
    shairport-sync \
    shairport-sync-metadata-reader \
"

MIKROBUS_INSTALL = " \
    clicks-board-init \
"

CONNECTIVITY_INSTALL = " \
    dnsmasq \
    wpa-supplicant \
    wpa-supplicant-passphrase \
    iw \
    hostapd \
    bluez5 \
    mosquitto \
    mosquitto-clients \
    libmosquitto1 \
    libmosquittopp1 \
    ppp \
    hologram-tools \
    networkmanager \
    modemmanager \
"

CORE_OS_INSTALL = " \
	hwrevision \
    dbus \
    sysfsutils \
    kernel-modules \
    swupdate \
    swupdate-www \
    swupdate-tools \
"

IMAGE_INSTALL += " \
    ${CORE_OS_INSTALL} \
    openssh-sftp-server \
    packagegroup-distro-base \
    packagegroup-machine-base \
    ${AUDIO_INSTALL} \
    ${MIKROBUS_INSTALL} \
    ${CONNECTIVITY_INSTALL} \
    packagegroup-iot-base \
    packagegroup-tools-io \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "base-image"
