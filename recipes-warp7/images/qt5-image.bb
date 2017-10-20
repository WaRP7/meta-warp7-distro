DESCRIPTION = "Qt image"
LICENSE = "MIT"

inherit base-image

IMAGE_INSTALL += "\
	packagegroup-qt5 \
"

export IMAGE_BASENAME = "qt5-image"
