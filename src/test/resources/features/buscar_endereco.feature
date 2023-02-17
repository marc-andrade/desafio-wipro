Feature: Buscar endereço e calcular frete

  Background:
    Given A API de busca de CEP está disponível

  Scenario: Busca de endereço e frete para um CEP válido
    When o usuário busca o endereço para o CEP "01001000"
    Then o endereço completo é retornado
    And o frete é calculado corretamente de acordo com a região

  Scenario: Busca de endereço e frete para um CEP inválido
    When o usuário busca o endereço para o CEP "00000-000"
    Then a mensagem de erro é retornada