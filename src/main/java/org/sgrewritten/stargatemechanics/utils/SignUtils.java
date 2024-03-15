package org.sgrewritten.stargatemechanics.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.sgrewritten.stargate.api.gate.GateAPI;
import org.sgrewritten.stargate.api.network.Network;
import org.sgrewritten.stargate.api.network.RegistryAPI;
import org.sgrewritten.stargate.api.network.portal.*;
import org.sgrewritten.stargate.api.network.portal.flag.PortalFlag;
import org.sgrewritten.stargate.network.StorageType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SignUtils {
    public static void removeSignsFromPortal(RealPortal portal) {
        List<PortalPosition> positionsToRemove = new ArrayList<>();
        GateAPI gate = portal.getGate();
        for(PortalPosition portalPosition : gate.getPortalPositions()) {
            if(portalPosition.getPluginName().equals("Stargate") && portalPosition.getPositionType() == PositionType.SIGN){
                positionsToRemove.add(portalPosition);
            }
        }
        for(PortalPosition portalPosition : positionsToRemove) {
            Location location = gate.getLocation(portalPosition.getRelativePositionLocation());
            gate.removePortalPosition(location);
            location.getBlock().setType(Material.AIR);
        }
    }
}
