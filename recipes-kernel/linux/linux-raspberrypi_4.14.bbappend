FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-usb-dwc2-Disable-all-EP-s-on-disconnect.patch file://0002-usb-dwc2-Fix-disable-all-EP-s-on-disconnect.patch"
