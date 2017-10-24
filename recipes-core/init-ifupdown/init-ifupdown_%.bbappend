# Customization of init-ifupdown

# Files directory
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Sources
SRC_URI_append = " \
    file://interfaces \
    file://interfaces.dhcp \
"

# Install a new file interfaces file if we want to connect wlan0 with a public WiFi
do_install_append() {
	install -m 0644 ${S}/interfaces.dhcp ${D}${sysconfdir}/network
}
