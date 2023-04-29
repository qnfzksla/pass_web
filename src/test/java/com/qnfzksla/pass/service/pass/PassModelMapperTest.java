package com.qnfzksla.pass.service.pass;

import com.qnfzksla.pass.repository.packaze.PackageEntity;
import com.qnfzksla.pass.repository.pass.PassEntity;
import com.qnfzksla.pass.repository.pass.PassStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassModelMapperTest {

    @Test
    public void test_toPasses() {
        // when
        final LocalDateTime now = LocalDateTime.now();

        final PackageEntity packageEntity = new PackageEntity();
        packageEntity.setPackageSeq(1);
        packageEntity.setPackageName("패키지1");
        packageEntity.setCount(10);
        packageEntity.setPeriod(30);

        final PassEntity passEntity = new PassEntity();
        passEntity.setPassSeq(1);
        passEntity.setStatus(PassStatus.READY);
        passEntity.setRemainingCount(10);
        passEntity.setStartedAt(now.plusDays(1));
        passEntity.setEndedAt(passEntity.getStartedAt().plusDays(30));
        passEntity.setPackageSeq(1);
        passEntity.setPackageEntity(packageEntity);

        // given
        final List<Pass> passes = PassModelMapper.INSTANCE.map(List.of(passEntity));

        // then
        assertEquals(1, passes.size());
        final Pass pass = passes.get(0);

    }

}