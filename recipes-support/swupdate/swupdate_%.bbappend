FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	"	
	
pkg_postinst_${PN} () {
#!/bin/sh -e
if [ x"$D" = "x" ]; then
    echo "WaRP7 0.2" > /etc/hwrevision
else
    exit 1
fi	 
}
