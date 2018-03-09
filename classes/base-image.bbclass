DESCRIPTION = "Basic image"
LICENSE = "MIT"

# set password to iot
inherit extrausers
EXTRA_USERS_PARAMS = " \
    usermod -P iot root; \
    "

inherit core-image image-buildinfo

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

MENDER_INSTALL = " \
    state-scripts \
    mender-qt-updater \
"

CONNECTIVITY_INSTALL = " \
    dnsmasq \
    iw \
    hostapd \
    bluez5 \
    mosquitto \
    mosquitto-clients \
    libmosquitto1 \
    libmosquittopp1 \
    hologram-tools \
    modemmanager \
"

CORE_OS_INSTALL = " \
    hwrevision \
    sysfsutils \
    kernel-image \
    kernel-modules \
    kernel-devicetree \
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
    ${MENDER_INSTALL} \
    ${MIKROBUS_INSTALL} \
    ${CONNECTIVITY_INSTALL} \
    packagegroup-iot-base \
    packagegroup-tools-io \
"

export IMAGE_BASENAME = "base-image"

IMAGE_BUILDINFO_VARS = " \
    BB_VERSION \
    BUILD_SYS  \
    NATIVELSBSTRING \
    TARGET_SYS \
    MACHINE \
    DISTRO \
    DISTRO_VERSION \
    TUNE_FEATURES \
    TARGET_FPU \
"

buildinfo () {
cat > ${IMAGE_ROOTFS}${sysconfdir}/build-info << END
Build Configuration:
${@buildinfo_target(d)}
${@get_layer_revs(d)}
END
}
