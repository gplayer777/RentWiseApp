package pl.spring.rentwise.assignment;

import pl.spring.rentwise.user.User;
import pl.spring.rentwise.inventory.asset.Asset;

public class AssignmentMapper {

    static AssignmentDto toDto(Assignment assignment) {
        AssignmentDto dto = new AssignmentDto();
        User user = assignment.getUser();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        return dto;
    }
}
