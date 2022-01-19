package example.spring.aop.concert;

public aspect CriticAspect {

    private CriticismEngine criticismEngine;

    public CriticAspect() {

    }

    pointcut performance() : execution(* example.spring.aop.concert.Performance.perform(..));

    after() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
