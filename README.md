# Fintech Simulator

API REST que simula um servico basico de transferencia entre contas, utilizando Java Spring.

O Servico conta com dois tipos de usuarios, usuarios comuns e lojistas, e a regra de negocio nao permite transferencias de lojistas para outras contas, apenas de usuarios comuns para lojistas, ou usuarios comuns para outros usuarios comuns.

A regra de transferencia, alem das validacoes basicas como verificacao de saldo em conta, e se quem envia e quem recebe de fato existe na base, tambem simula uma validacao consumindo um servico externo.
