package pl.spring.rentwise.assignment;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.spring.rentwise.user.User;
import pl.spring.rentwise.user.UserRepository;
import pl.spring.rentwise.inventory.asset.Asset;
import pl.spring.rentwise.inventory.asset.AssetRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, AssetRepository assetRepository, UserRepository userRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    AssignmentDto createAssignment(AssignmentDto assignmentDto) {
        Optional<Assignment> activeAssignmentForAsset = assignmentRepository.findByAsset_IdAndEndIsNull(assignmentDto.getAssetId());
        activeAssignmentForAsset.ifPresent((a) ->{
            throw new InvalidAssignmentException("This quipment is already assigned");

        });
        Optional<User> user = userRepository.findById(assignmentDto.getUserId());
        Optional<Asset> asset = assetRepository.findById(assignmentDto.getAssetId());
        Assignment assignment = new Assignment();
        Long userId = assignmentDto.getUserId();
        Long assetId = assignmentDto.getAssetId();
        assignment.setUser(user.orElseThrow(() ->
                new InvalidAssignmentException("Brak użytkownika z id: " + userId)));
        assignment.setAsset(asset.orElseThrow(() ->
                new InvalidAssignmentException("Brak wyposażenia z id: " + assetId)));
        assignment.setStart(LocalDateTime.now());
        return AssignmentMapper.toDto(assignmentRepository.save(assignment));

    }

    @Transactional
    public LocalDateTime finishAssignment(Long assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        Assignment assignmentEntity = assignment.orElseThrow(AssignmentNotFoundException::new);
        if (assignmentEntity.getEnd() != null) {
            throw new AssignmentAlreadyFinishedException();
        } else {
            assignmentEntity.setEnd(LocalDateTime.now());
        }
        return assignmentEntity.getEnd();
    }


}
