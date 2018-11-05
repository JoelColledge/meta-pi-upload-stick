# Exclude thin-provisioning-tools (which require boost), but include thin support
PACKAGECONFIG="dmeventd lvmetad odirect udev"
EXTRA_OECONF_append=" --with-thin=internal"

SYSTEMD_AUTO_ENABLE="enable"
