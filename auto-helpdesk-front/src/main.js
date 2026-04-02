import './style.css';

const API_BASE = 'http://localhost:8080';

// --- NAVEGAÇÃO ---
const links = document.querySelectorAll('.nav-link');
const sections = document.querySelectorAll('.view-section');

links.forEach(link => {
  link.addEventListener('click', (e) => {
    e.preventDefault();
    links.forEach(l => l.classList.remove('active'));
    sections.forEach(s => s.classList.remove('active'));
    
    link.classList.add('active');
    document.getElementById(link.getAttribute('data-target')).classList.add('active');
  });
});

// Funções Auxiliares de Fetch
async function apiPost(endpoint, body) {
  const res = await fetch(`${API_BASE}${endpoint}`, {
    method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(body)
  });
  return res.ok;
}
async function apiGet(endpoint) {
  const res = await fetch(`${API_BASE}${endpoint}`);
  return await res.json();
}

// ==========================================
// 1. OrdemServicoService
// ==========================================
document.getElementById('form-os').addEventListener('submit', async (e) => {
  e.preventDefault();
  const ok = await apiPost('/os', {
    clienteId: document.getElementById('osClienteId').value,
    oficinaId: document.getElementById('osOficinaId').value,
    modeloVeiculo: document.getElementById('osModelo').value,
    descricaoProblema: document.getElementById('osProblema').value
  });
  if(ok) { 
    alert('OS Criada!'); 
    document.getElementById('form-os').reset(); 
    carregarOS(); 
  }
});

document.getElementById('btnAtualizarOS').addEventListener('click', carregarOS);

async function carregarOS() {
  const ordens = await apiGet('/os');
  const tbody = document.querySelector('#tabela-os tbody');
  
  tbody.innerHTML = ordens.map(os => `
    <tr>
      <td>${os.id}</td>
      
      <td>${os.cliente ? os.cliente.id : 'N/A'}</td>
      
      <td>${os.oficina ? os.oficina.id : 'N/A'}</td>
      
      <td>${os.modeloVeiculo}</td>
      <td>
        <select onchange="atualizarStatusOS(${os.id}, this.value)">
          <option value="ABERTA" ${os.status === 'ABERTA' ? 'selected' : ''}>Aberta</option>
          <option value="EM_ANDAMENTO" ${os.status === 'EM_ANDAMENTO' ? 'selected' : ''}>Em Andamento</option>
          <option value="AGUARDANDO_PECA" ${os.status === 'AGUARDANDO_PECA' ? 'selected' : ''}>Aguardando Peça</option>
          <option value="FECHADA" ${os.status === 'FECHADA' ? 'selected' : ''}>Fechada</option>
        </select>
      </td>
      <td><button onclick="abrirChat(${os.id})">Abrir Chat</button></td>
    </tr>
  `).join('');
}

// NOVA FUNÇÃO: Atualiza o status enviando o Enum via RequestBody
window.atualizarStatusOS = async (id, novoStatus) => {
  try {
    // A URL agora NÃO tem mais o "?status=..." no final
    const res = await fetch(`${API_BASE}/os/${id}/status`, {
      method: 'PATCH',
      headers: {
        'Content-Type': 'application/json' // Avisamos ao Java que estamos mandando um JSON
      },
      // Enviamos o valor do Enum formatado para JSON (ex: "ABERTA")
      body: JSON.stringify(novoStatus) 
    });

    if (res.ok) {
      alert('Status da OS atualizado com sucesso!');
      carregarOS(); // Recarrega a tabela para confirmar a alteração
    } else {
      const erroTexto = await res.text();
      console.error('Erro do Backend:', erroTexto);
      alert('Erro ao atualizar a OS. Olhe o console (F12) para detalhes.');
    }
  } catch (erro) {
    console.error('Erro de rede:', erro);
    alert('Falha na comunicação com o servidor.');
  }
};
// ==========================================
// 2. AgendamentoService
// ==========================================
document.getElementById('form-agendamento').addEventListener('submit', async (e) => {
  e.preventDefault();
  
  const ok = await apiPost('/agendamentos', {
    clienteId: document.getElementById('agClienteId').value,
    oficinaId: document.getElementById('agOficinaId').value,
    dataAgendamento: document.getElementById('agData').value, 
    tipoServico: document.getElementById('agTipo').value
  });
  
  if(ok) { 
    alert('Agendamento Criado!'); 
    document.getElementById('form-agendamento').reset(); 
    carregarAgendamentos(); // <-- Descomentado para atualizar a lista automaticamente
  }
});

document.getElementById('btnAtualizarAgendamento').addEventListener('click', carregarAgendamentos);

async function carregarAgendamentos() {
  const agendamentos = await apiGet('/agendamentos');
  const tbody = document.querySelector('#tabela-agendamento tbody');
  
  // A linha abaixo foi alterada para adicionar o menu <select>
 tbody.innerHTML = agendamentos.map(ag => `
    <tr>
      <td>${ag.id}</td>
      
      <td>${ag.cliente ? ag.cliente.id : 'N/A'}</td>
      
      <td>${ag.oficina ? ag.oficina.id : 'N/A'}</td>
      
      <td>${new Date(ag.dataHoraAgendamento).toLocaleString('pt-BR')}</td>
      <td>${ag.tipoServico}</td>
      <td>
        <select onchange="atualizarStatusAgendamento(${ag.id}, this.value)">
          <option value="PEDENTE" ${ag.status === 'PEDENTE' ? 'selected' : ''}>Pendente</option>
          <option value="CONFIRMADO" ${ag.status === 'CONFIRMADO' ? 'selected' : ''}>Confirmado</option>
          <option value="CONCLUIDO" ${ag.status === 'CONCLUIDO' ? 'selected' : ''}>Concluído</option>
          <option value="CANCELADO" ${ag.status === 'CANCELADO' ? 'selected' : ''}>Cancelado</option>
        </select>
      </td>
    </tr>
  `).join('');
}

// NOVA FUNÇÃO: Disparada quando você troca a opção no menu
window.atualizarStatusAgendamento = async (id, novoStatus) => {
  try {
    // Agora enviamos como PATCH e passamos o status como Query Parameter na URL
    const res = await fetch(`${API_BASE}/agendamentos/${id}/status?status=${novoStatus}`, {
      method: 'PATCH'
      // Como não estamos enviando um JSON no corpo (body), não precisamos de headers e body aqui
    });

    if (res.ok) {
      alert('Status atualizado com sucesso!');
      carregarAgendamentos(); // Recarrega a tabela para confirmar a alteração
    } else {
      // Se der erro, tenta pegar a mensagem que o Java retornou para ajudar a descobrir
      const erroTexto = await res.text();
      console.error('Erro do Backend:', erroTexto);
      alert('Erro ao atualizar o status. Olhe o console (F12) para mais detalhes.');
    }
  } catch (erro) {
    console.error('Erro de rede ao atualizar status:', erro);
    alert('Falha na comunicação com o servidor.');
  }
};
// ==========================================
// 3. OficinaParceiroService
// ==========================================
document.getElementById('form-oficina').addEventListener('submit', async (e) => {
  e.preventDefault();
  const ok = await apiPost('/oficinas', {
    nome: document.getElementById('ofNome').value,
    latitude: parseFloat(document.getElementById('ofLat').value),
    longitude: parseFloat(document.getElementById('ofLng').value),
    endereco: document.getElementById('ofEndereco').value
  });
  if(ok) { alert('Oficina Cadastrada!'); document.getElementById('form-oficina').reset(); carregarOficinas(); }
});

document.getElementById('btnAtualizarOficina').addEventListener('click', carregarOficinas);
async function carregarOficinas() {
  const oficinas = await apiGet('/oficinas');
  const tbody = document.querySelector('#tabela-oficina tbody');
  tbody.innerHTML = oficinas.map(of => `
    <tr><td>${of.id}</td><td>${of.nome}</td><td>Lat: ${of.latitude} | Lng: ${of.longitude}</td><td>${of.endereco}</td></tr>
  `).join('');
}

// ==========================================
// 4. UsuarioService
// ==========================================
document.getElementById('form-usuario').addEventListener('submit', async (e) => {
  e.preventDefault();
  const ok = await apiPost('/usuarios', {
    nome: document.getElementById('usuNome').value,
    email: document.getElementById('usuEmail').value,
    senha: document.getElementById('usuSenha').value,
    perfil: document.getElementById('usuPerfil').value
  });
  if(ok) { alert('Usuário Salvo!'); document.getElementById('form-usuario').reset(); carregarUsuarios(); }
});

document.getElementById('btnAtualizarUsuario').addEventListener('click', carregarUsuarios);
async function carregarUsuarios() {
  const usuarios = await apiGet('/usuarios');
  const tbody = document.querySelector('#tabela-usuario tbody');
  tbody.innerHTML = usuarios.map(u => `
    <tr><td>${u.id}</td><td>${u.nome}</td><td>${u.email}</td><td>${u.perfil}</td></tr>
  `).join('');
}

// ==========================================
// 5. MensagemChatService
// ==========================================
window.abrirChat = (osId) => {
  document.getElementById('chatOrdemServicoId').value = osId;
  document.getElementById('chat-os-id').innerText = osId;
  document.querySelector('[data-target="sec-chat"]').click();
  carregarChat(osId);
};

document.getElementById('form-chat').addEventListener('submit', async (e) => {
  e.preventDefault();
  const osId = document.getElementById('chatOrdemServicoId').value;
  if(!osId) return alert('Selecione uma OS primeiro!');
  
  const ok = await apiPost('/chat', {
    ordemServicoId: parseInt(osId),
    remetenteId: parseInt(document.getElementById('chatRemetenteId').value),
    mensagem: document.getElementById('chatMensagem').value
  });
  if(ok) { document.getElementById('chatMensagem').value = ''; carregarChat(osId); }
});

async function carregarChat(osId) {
  const mensagens = await apiGet(`/chat/historico/${osId}`);
  const hist = document.getElementById('chat-historico');
  const meuId = parseInt(document.getElementById('chatRemetenteId').value);
  
  hist.innerHTML = mensagens.map(msg => `
    <div class="msg-box ${msg.remetenteId === meuId ? 'minha' : ''}">
      <small>Remetente ID: ${msg.remetenteId} - ${new Date(msg.dataEnvio).toLocaleString('pt-BR')}</small>
      <div>${msg.mensagem}</div>
    </div>
  `).join('');
  hist.scrollTop = hist.scrollHeight;
}

// Init
window.onload = () => { carregarOS(); carregarAgendamentos(); carregarOficinas(); carregarUsuarios(); };