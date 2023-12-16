
function solution(land) {
    const n = land.length;
    const m = land[0].length;
    const dirX = [0,1,0,-1];
    const dirY = [1,0,-1,0];
    let oilCount = 2;
    const oilSize = [0,0];
    function countOil(y, x , number){
        let count = 0;
        if(land[y][x] === 1){
            count++;
            land[y][x] = number;
            for(let t = 0;t< 4;t++){
                const nextY = y + dirY[t];
                const nextX = x + dirX[t];
                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && land[nextY][nextX] < 2){
                    count += countOil(nextY, nextX, number);
                }
            }
        }
        return count;
    }

    let answer = 0;
    for(let i = 0; i< m;i ++){
        for(let j = 0;j< n;j++){
            if(land[j][i]===1 && land[j][i] <2){
                oilSize.push(countOil(j,i, oilCount++));
            }
        }
    }

    for(let i = 0;i < m;i++){
        let lineSum = 0;
        const checked = [];
        for(let j = 0;j< n;j++){
            if(land[j][i] !== 0 && !checked.includes(land[j][i])){
                lineSum += oilSize[land[j][i]];
                checked.push(land[j][i]);
            }
        }
        answer = Math.max(answer, lineSum);
    }
    return answer;
}



console.log(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]))
console.log(solution([[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]))