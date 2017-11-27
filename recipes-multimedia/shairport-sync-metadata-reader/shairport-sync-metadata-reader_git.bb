DESCRIPTION = "Sample Shairport Sync Metadata Player"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6a0b567fccdf862155f0d7e9449c2db"

SRC_URI = " \
	git://github.com/mikebrady/shairport-sync-metadata-reader.git;protocol=git \
	"

SRCREV = "73acf65aa954d28ecfb73cfee8fc30f6530e1a65"

S = "${WORKDIR}/git"

inherit autotools
