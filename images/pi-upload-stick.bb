SUMMARY = "Makes a raspberry pi behave as a USB mass storage device (memory stick) that automatically uploads files"
LICENSE = "MIT"

IMAGE_FEATURES += ""
IMAGE_LINGUAS = "en-us"

inherit image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    kernel-modules \
    openssh \
    linux-firmware-bcm43430 \
    packagegroup-core-boot \
    tzdata \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    wireless-tools \
    wpa-supplicant \
    systemd-wireless-auto \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gdb \
    gdbserver \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python3-modules \
"

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho  \
    spiloop \
"

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    devmem2 \
    dosfstools \
    ethtool \
    fbset \
    findutils \
    i2c-tools \
    iperf3 \
    iproute2 \
    iptables \
    less \
    nano \
    netcat \
    procps \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    wget \
    zip \
"

RPI_STUFF = " \
    omxplayer \
    raspi2fb \
    userland \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${WIFI_SUPPORT} \
    wpa-supplicant-private-conf \
    parted \
    lvm2 \
    e2fsprogs-resize2fs \
    dosfstools \
    vorbis-tools \
    rsync \
    util-linux-lsblk \
    systemd-analyze \
    mass-storage-tune \
    upload-stick \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "pi-upload-stick"
