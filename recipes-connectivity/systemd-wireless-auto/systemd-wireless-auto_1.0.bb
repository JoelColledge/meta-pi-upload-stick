SUMMARY = "Automatically connect on hardcoded wireless link and use DHCP"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wireless.network"

do_install () {
        install -d ${D}${sysconfdir}/systemd/network
        install -m 644 ${WORKDIR}/wireless.network ${D}${sysconfdir}/systemd/network/wireless.network

        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
        cd ${D}${sysconfdir}/systemd/system/multi-user.target.wants/ && \
        ln -sf ../../../../lib/systemd/system/wpa_supplicant@.service wpa_supplicant@wlan0.service
}
