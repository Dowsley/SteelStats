# Amostras

## Dicas de Tiago para OEE (Eventos):
Sugestão de fazer três níveis de OEE (Diário, semanal, mensal), *"pode simplesmente somar tudo que for do msm equipamento por dia"*
- *as linhas são em períodos de Minutos*
- Calculo de Disponibilidade: *seria Production_Time / (Unplanned_Time + Production_Time)* -> [NÃO HÁ NO POWERBI]
- Calcular Performance: *Theoretical_Duration_By_PPH_For_Calculation / Theoretical_Duration_By_PPH*
- Calcular Qualidade: *(QTY_Produced - Metallic_loss - Qty_Produced_Rework) / Qty_Produced*, mas como qty_produced_rework ta como 0 sempre, dá pra ignorar.

## Dicas de Tiago para PERDAS:

- soma das paradas = É os minutos de todas as falhas durante o dia = "des_tipo_falha" -> row[3] somados.
- Tempo Calendario = 1440(minutos/dia)  
- Tempo Livre =  soma de paradas com tipo de falha LIVRE - des_tipo_falha -> LIVRE
- Causas Externas = soma de paradas com tipo de falha EXTERNA - des_tipo_falha -> EXTERNA
- Paradas Programadas = soma de paradas com tipo de falha PROGRAMADA - des_tipo_falha -> PROGRAMADA
- Interrupções: soma das paradas  menos (paradas do tipo EXTERNA, LIVRE e PROGRAMADA)
Ex:
Interrupções = soma das paradas - (Causas Externas+ Tempo Livre + Paradas Programadas)
- Tempo Programado Total = Tempo Calendario - (Tempo Livre + Causas Externas)
- Tempo Programado Produção = Tempo Programado Total - Paradas Programadas
- Tempo Util = Tempo Programado Produção - Interrupções
- *Utilização Programação Total = (Tempo Util / Tempo Programado Total) * 100
- *Utilização Programação Produção = (Tempo Util / Tempo Programado Produção) * 100
*Os resultados são mostrados em percentual.

Feito os calculos , implementar graficos de impacto de equipamento nas paradas da área, percentual de utilização área, grafico de parada ao longo do tempo entre outras finitas possibilidades.
