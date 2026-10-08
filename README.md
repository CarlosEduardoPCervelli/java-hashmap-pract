# Palíndromos e Anagramas

Dado um texto, diz se é **palíndromo**; dadas duas palavras, diz se são
**anagramas**. Ignora espaços, acentos, pontuação e maiúsculas/minúsculas.

## Como funciona

- `normalizar(texto)`: usa `Normalizer.normalize(..., NFD)` para separar a
  letra do acento, remove os acentos com `replaceAll("\\p{M}", "")`, deixa
  em minúsculas e tira tudo que não for letra ou número.
- `isPalindromo(texto)`: normaliza o texto e compara com ele mesmo invertido
  (`StringBuilder.reverse()`).
- `isAnagrama(a, b)`: normaliza as duas palavras, ordena os caracteres de
  cada uma (`Arrays.sort`) e compara. Se as letras ordenadas forem iguais,
  são anagramas.

## Exemplos

| Entrada                          | Resultado          |
|----------------------------------|--------------------|
| `Ame a ema`                      | palíndromo         |
| `A sogra má e amargosa`          | palíndromo         |
| `Java`                           | não é palíndromo   |
| `Roma` e `Amor`                  | anagramas          |
| `Escola` e `Cola`                | não são anagramas  |

## Como executar

```bash
cd src
javac PalindromosAnagramas.java
java PalindromosAnagramas
```

## Possíveis melhorias futuras
- Implementar o anagrama também com `HashMap<Character, Integer>`
  (contando a frequência de cada letra) e comparar as duas abordagens.
- Testes unitários com JUnit.
