DESCRIPTION = "AirPlay audio player. Shairport Sync adds multi-room capability with Audio Synchronisation"
LICENSE="MIT & BSD"
LIC_FILES_CHKSUM = "file://LICENSES;md5=926dc741301c0ecd801c957fa35c097a"

SRC_URI = " \ 
	git://github.com/mikebrady/shairport-sync.git;protocol=git \
	file://shairport-sync.conf \	
	file://shairport-sync \
	"

SRCREV = "61da67aa01e584ac8ddae1c795cce0f0805c7dfb"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
	--with-alsa \
	--with-stdout \
    	--with-ssl=openssl \
    	--with-avahi \
    	--with-metadata \
"

DEPENDS = " libconfig popt avahi openssl alsa-lib"

inherit autotools pkgconfig update-rc.d

do_install() {
		
        install -d ${D}${sysconfdir}/
        install -d ${D}${sysconfdir}/init.d/
        install -d ${D}${bindir}/
        
        install -m 0644 ${WORKDIR}/shairport-sync.conf ${D}${sysconfdir}/
        install -m 0755 ${WORKDIR}/shairport-sync ${D}${sysconfdir}/init.d/
        install -m 0755 ${B}/shairport-sync ${D}${bindir} 
}

INITSCRIPT_NAME = "shairport-sync"
INITSCRIPT_PARAMS = "defaults"
