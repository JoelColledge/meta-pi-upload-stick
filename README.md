Yocto layer defining an image that makes a Raspberry Pi Zero W behave as a USB stick that automatically uploads WAV
audio files that are written to it.

# Dependencies

```
git://git.yoctoproject.org/poky.git
git://git.openembedded.org/meta-openembedded
https://github.com/agherzan/meta-raspberrypi.git
```

# Building the image

* Clone this repository
* Clone the above dependencies and checkout branch `sumo` (`git clone -b sumo ...`)
* Create a build directory e.g. `builds/rpi0`
* Initialize build environment `. poky/oe-init-build-env builds/rpi0`
* Tell `bitbake` where to find the layers by creating `conf/bblayers.conf` in the build directory (see `example/bblayers.conf`)
* Tell `bitbake` what to build by creating by creating `conf/local.conf` in the build directory (see `example/local.conf`)
* Build with `bitbake pi-upload-stick`; this may take a long time

## Add wifi network connection credentials

* Add a new layer for your private wifi credentials (see `example/meta-local-private`)
* Add this layer to `example/bblayers.conf`
* Build again
