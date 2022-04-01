import request from './request.js'

//直接声明一个URL存储接口地址
const URL = {
    GET_IDIOM_BY_ID: '/idiom/queryById',
    GET_IDIOM_BY_WORD: '/idiom/queryByWord',
    GET_IDIOM_BY_KEYWORD: '/idiom/fuzzyQueryByWord',
    GET_IDIOM_BY_RANDOM: '/idiom/randomQuery',
};

export default {
    /**
     * 根据ID精确查找
     */
    queryById({ id }) {
        return request(URL.GET_IDIOM_BY_ID, 'GET', { id });
    },
    /**
     * 根据词语精确查找
     */
    queryByWord({ word }) {
        return request(URL.GET_IDIOM_BY_WORD, 'GET', { word });
    },
    /**
     * 根据部分关键词查找匹配的条目
     */
    fuzzyQueryByWord({ word }) {
        return request(URL.GET_IDIOM_BY_KEYWORD, 'GET', { word });
    },
    /**
     * 随机查询n条数据
     */
    randomQuery({ limit }) {
        return request(URL.GET_IDIOM_BY_RANDOM, 'GET', { limit });
    },
};