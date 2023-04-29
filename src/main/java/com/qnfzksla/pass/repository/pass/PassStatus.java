package com.qnfzksla.pass.repository.pass;

public enum PassStatus {
    READY, PROGRESSED, EXPIRED
}

//통과 상태 상태 = 통과 상태입니다.준비;
//if(상태 == PassStatus).준비됨) { READY
//System.out.println("패스를 사용할 준비가 되었습니다.");
//} 그렇지 않으면 (상태 == 통과 상태).진행됨) { PROGRESSED
//System.out.println("패스가 사용되었지만 여전히 유효합니다.");
//} 그렇지 않으면 (상태 == 통과 상태).만료됨) { EXPIRED
//System.out.println("패스가 만료되어 사용할 수 없습니다.");
//}
