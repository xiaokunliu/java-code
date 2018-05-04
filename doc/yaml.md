#### YAML基础
> 参考链接
http://www.ruanyifeng.com/blog/2016/07/yaml.html

> 基本语法

* 大小写敏感
* 使用缩进表示层级关系
* 缩进时不允许使用Tab键，只允许使用空格。
* 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可

> 注释

* '#'表示注释,从这个字符一直到行尾，都会被解析器忽略

> 支持三种数据结构

* 对象：键值对的集合，又称为映射（mapping）/ 哈希（hashes） / 字典（dictionary）
* 数组：一组按次序排列的值，又称为序列（sequence） / 列表（list）
* 纯量（scalars）：单个的、不可再分的值

> 对象

```code
## yaml1:使用冒号结构表示
animal: pets

## JS 1
{ animal: 'pets' }


## yaml2:将所有键值对写成一个行内对象
hash: { name: Steve, foo: bar } 

## 转成JS 2
{ hash: { name: 'Steve', foo: 'bar' } }
```

> 数组:一组连词线开头的行，构成一个数组

```
## yaml 1
- Cat
- Dog
- Goldfish

## JS 1
[ 'Cat', 'Dog', 'Goldfish' ]

## yaml 2
-
 - Cat
 - Dog
 - Goldfish

## JS 2
[ [ 'Cat', 'Dog', 'Goldfish' ] ]

## yaml 3
animal: [Cat, Dog]

## JS 3
{ animal: [ 'Cat', 'Dog' ] }
```

> 复合结构:对象和数组可以结合使用，形成复合结构

```code
## yaml 
languages:
 - Ruby
 - Perl
 - Python 
websites:
 YAML: yaml.org 
 Ruby: ruby-lang.org 
 Python: python.org 
 Perl: use.perl.org 
 
 
## JS
{ languages: [ 'Ruby', 'Perl', 'Python' ],
   websites: 
    { YAML: 'yaml.org',
      Ruby: 'ruby-lang.org',
      Python: 'python.org',
      Perl: 'use.perl.org' 
     } 
}
```

> 纯量:纯量是最基本的、不可再分的值

* 字符串
* 布尔值
* 整数
* 浮点数
* Null
* 时间
* 日期

