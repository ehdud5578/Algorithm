function solution(bandage, health, attacks) {
    const maxHealth = health;
    let continus = 0;
    let attackIndex = 0;
    const charge = bandage[0];
    const timeIncrease = bandage[1];
    const bonusIncreas = bandage[2];
    for (let i = 0; i < Number.MAX_VALUE; i ++){
        debugger;
        if(attacks[attackIndex][0] === i){
            const attackDamage = attacks[attackIndex][1];
            health = health - attackDamage;
            attackIndex++;
            continus = 0;
        }else{
            health += timeIncrease;
            continus++;
            if(continus === charge){
                health += bonusIncreas;
                continus = 0;
            }
        }

        if(health > maxHealth){
            health = maxHealth;
        }
        if(health <= 0){
            return -1;
        }
        if(attackIndex >= attacks.length){
            break;
        }
    }
    return health;
}

console.log(solution([5, 1, 5], 30 ,[[2, 10], [9, 15], [10, 5], [11, 5]]));
console.log(solution([3, 2, 7],	20,	[[1, 15], [5, 16], [8, 6]]));
console.log(solution([4, 2, 7],	20,	[[1, 15], [5, 16], [8, 6]]));
console.log(solution([1, 1, 1]	,5	,[[1, 2], [3, 2]]));