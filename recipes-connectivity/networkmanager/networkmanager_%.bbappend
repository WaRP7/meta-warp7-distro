FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://NetworkManager.conf \
    file://system-connections/ \
"

PACKAGECONFIG = " \
    systemd \
    modemmanager \
    ppp \
    concheck \
    wifi \
    nss \
    ifupdown \
    netconfig \
    dhclient \
    dnsmasq \
"
DEPENDS += "systemd"

do_install_append(){
    mkdir -p ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 0644 ${WORKDIR}/NetworkManager.conf ${D}${sysconfdir}
    install -m 0600 ${WORKDIR}/system-connections/* ${D}${sysconfdir}/NetworkManager/system-connections/
}
