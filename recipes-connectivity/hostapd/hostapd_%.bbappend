# Customization of hostapd

# Files directory
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Sources
SRC_URI_append = " \
    file://hostapd.conf \
"

# Install configuration
do_install_append() {
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}
}
