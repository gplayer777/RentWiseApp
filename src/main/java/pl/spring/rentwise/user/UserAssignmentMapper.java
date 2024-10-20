package pl.spring.rentwise.user;

import pl.spring.rentwise.assignment.Assignment;
import pl.spring.rentwise.inventory.asset.Asset;

public class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment) {
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
